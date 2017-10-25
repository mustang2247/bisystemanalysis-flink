package com.mybitop.biaflink.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropUtil {

    private static final Logger logger = LoggerFactory
            .getLogger( PropUtil.class );

    public static InputStream getRemoteInputStream( String urlPath ) {
        URL url = null;
        InputStream is = null;
        try {
            url = new URL( urlPath );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput( true );
            conn.connect();
            is = conn.getInputStream();
        }
        catch( Exception e ) {
            logger.error( e.getMessage(), e );
        }
        return is;
    }

    public static InputStream getInputStream( String filePath ) {
        InputStream in = Object.class.getResourceAsStream( filePath );

        if( in == null ) {
            in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream( filePath );
        }
        if( in == null ) {
            in = ClassLoader.getSystemResourceAsStream( filePath );
        }
        if( in == null ) {
            in = ClassLoader.getSystemClassLoader().getResourceAsStream( filePath );
        }
        if( in == null ) {
            in = Object.class.getClassLoader().getResourceAsStream( filePath );
        }

        return in;
    }

    public static String getProp( String filePath, String key ) {

        Properties prop = new Properties();
        InputStream in = getInputStream( filePath );
        try {
            prop.load( in );
            return prop.getProperty( key ).trim();
        }
        catch( IOException e ) {
            logger.error( e.getMessage(), e );
        }

        return null;
    }

    public static String getRemoteProp( String filePath, String key ) {

        Properties prop = new Properties();
        InputStream in = getRemoteInputStream( filePath );
        try {
            prop.load( in );
            return prop.getProperty( key ).trim();
        }
        catch( IOException e ) {
            logger.error( e.getMessage(), e );
        }

        return null;
    }

    public static Properties getProps( String filePath ) {
        Properties prop = new Properties();
        InputStream in = getInputStream( filePath );
        try {
            prop.load( in );
            return prop;
        }
        catch( IOException e ) {
            logger.error( e.getMessage(), e );
        }

        return null;
    }

    public static Properties getRemoteProps( String filePath ) {
        Properties prop = new Properties();
        InputStream in = getRemoteInputStream( filePath );
        try {
            prop.load( in );
            return prop;
        }
        catch( IOException e ) {
            logger.error( e.getMessage(), e );
        }

        return null;
    }

    public static Map< String, Properties > getSectionProps( String filePath ) throws IOException {
        Map< String, Properties > rv = new HashMap<>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(
                getInputStream( filePath ) ) );
        String line = null;
        String section = null;
        Properties properties = null;
        while( ( line = reader.readLine() ) != null ) {
            line = line.trim();
            if( line.length() == 0 || line.startsWith( "#" ) ) continue;
            else if( line.matches( "\\[.*\\]" ) ) {
                section = line.replaceFirst( "\\[(.*)\\]", "$1" );
                properties = new Properties();
                rv.put( section, properties );
            }
            else if( line.matches( ".*=.*" ) ) {
                if( properties != null ) {
                    int i = line.indexOf( '=' );
                    String name = line.substring( 0, i ).trim();
                    String value = line.substring( i + 1 ).trim();
                    properties.setProperty( name, value );
                }
            }
        }

        return rv;
    }

    public static Map< String, Properties > getRemoteSectionProps( String filePath ) throws IOException {
        Map< String, Properties > rv = new HashMap<>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(
                getRemoteInputStream( filePath ) ) );
        String line = null;
        String section = null;
        Properties properties = null;
        while( ( line = reader.readLine() ) != null ) {
            line = line.trim();
            if( line.length() == 0 || line.startsWith( "#" ) ) continue;
            else if( line.matches( "\\[.*\\]" ) ) {
                section = line.replaceFirst( "\\[(.*)\\]", "$1" );
                properties = new Properties();
                rv.put( section, properties );
            }
            else if( line.matches( ".*=.*" ) ) {
                if( properties != null ) {
                    int i = line.indexOf( '=' );
                    String name = line.substring( 0, i ).trim();
                    String value = line.substring( i + 1 ).trim();
                    properties.setProperty( name, value );
                }
            }
        }

        return rv;
    }

    public static void main( String[] args ) {
        String val = PropUtil.getRemoteProp( "http://192.168.2.12:6173/fish_back_cfg/test.properties", "abc" );
        System.out.println( val );
    }
}

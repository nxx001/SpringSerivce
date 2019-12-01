package com.nx.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties props;
    private static Properties redisProps;
    private static Properties commonProps;
    private static String name;

    synchronized static private void loadProps(String fileName){
        logger.info("开始加载properties文件内容.......");
        logger.info(fileName);
        props = new Properties();
        InputStream in = null;
        try {
            //第一种，通过类加载器进行获取properties文件流
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
            //第二种，通过类进行获取properties文件流
            //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            logger.error(fileName+"文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("jdbc.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }


    public static String getProperty(String fileName,String key){
        if(null == props) {
            loadProps(fileName);
        }
        return props.getProperty(key);
    }

    public static String getProperty(String fileName,String key, String defaultValue) {
        if(null == props) {
            loadProps(fileName);
        }
        return props.getProperty(key, defaultValue);
    }

    public static Properties getAll(String fileName){
        logger.info("文件名："+fileName);
        logger.info("props:"+props);
        if(null == props){
            loadProps(fileName);
        }else{
            if(!props.propertyNames().equals(fileName)){ //这一步是为了判断再次读取的时候是否是相同文件
                loadProps(fileName);
            }
        }

        return props;
    }
}

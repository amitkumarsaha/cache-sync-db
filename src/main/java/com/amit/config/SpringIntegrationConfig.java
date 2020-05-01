//package com.amit.config;
//
//import java.io.File;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.InboundChannelAdapter;
//import org.springframework.integration.annotation.Poller;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.config.EnableIntegration;
//import org.springframework.integration.core.MessageSource;
//import org.springframework.integration.jdbc.JdbcMessageHandler;
//import org.springframework.integration.jdbc.config.JdbcMessageHandlerParser;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//
//@Configuration
//@EnableIntegration
//public class SpringIntegrationConfig{
//    public String INPUT_DIR = "the_source_dir";
//    public String OUTPUT_DIR = "the_dest_dir";
//    public String FILE_PATTERN = "*.mpeg";
// 
//    @Autowired
//    private DataSource dataSource;
//    
//    @Bean
//    public MessageChannel fileChannel() {
//        return new DirectChannel();
//    }
// 
//    @Bean
//    @InboundChannelAdapter(value = "dbChannel", poller = @Poller(fixedDelay = "4000"))
//    public MessageSource<File> dbReadingMessageSource() {
//        JdbcMessage jMP = new JdbcMessageHandlerParser();
//    	FileReadingMessageSource sourceReader= new FileReadingMessageSource();
//        sourceReader.setDirectory(new File(INPUT_DIR));
//        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
//        return sourceReader;
//    }
// 
//    @Bean
//    @ServiceActivator(inputChannel= "dbChannel")
//    public MessageHandler dbWritingMessageHandler() {
//    	JdbcMessageHandler handler = new JdbcMessageHandler(dataSource, null);
//        return handler;
//    }
//}

/**
 * 
 */
package com.sbheemineni.ads;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author SrinivasBheemineni
 * 
 * These two annotations (@Configuration & @EnableWebMvc) basically creates 
 * the same thing as application context and our dispatcher servlet or our servlet-config.
 * 
 * Now what happens is when our application loads it goes through and reads the class path
 * or anything with this annotation (@Configuration) on it and Spring automatically 
 * creates a context out of it, so it's smart about how to load it based off of that
 * configuration annotation.
 * 
 * The annotation (@EnableWebMvc) takes place or is rather in place of our servlet-config.xml
 * (component scan, view resolver etc), that we had in our xml configurations.
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sbheemineni.ads")
public class WebConfig {

}

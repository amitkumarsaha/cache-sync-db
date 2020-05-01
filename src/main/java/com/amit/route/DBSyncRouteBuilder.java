//package com.amit.route;
//
//import java.util.List;
//
//import org.apache.camel.Exchange;
//import org.apache.camel.Message;
//import org.apache.camel.Processor;
//import org.apache.camel.builder.RouteBuilder;
//
//public class DBSyncRouteBuilder extends RouteBuilder {
//
//	@Override
//	 public void configure() throws Exception {
//
//	  from("quartz2://sync/myTimer?trigger.repeatInterval=5000&stateful=true")
//	    .routeId("myRoute")
//	    .choice()
//	    .when()
//	    .simple("${header.jobDetail.jobDataMap[last_id]} == null")
//	    .setBody(constant("select * from student order by id "))
//	    .otherwise()
//	    .setBody(
//	      simple("select * from student where id> ${header.jobDetail.jobDataMap[last_id]} order by id"))
//	    //
//	    .end()
//	    .to("jdbc:ds?useHeadersAsParameters=true")
//	    .choice()
//	    .when()
//	    .simple("${header.CamelJdbcRowCount} > 0")
//	    .process(new Processor() {
//
//		@Override
//		public void process(Exchange exchange) throws Exception {
//			Message msg = exchange.getIn();
//			List data = msg.getBody(List.class);
////		      JobDetail jobDetail = (JobDetail) msg.getHeader("jobDetail");
////		      JobDataMap map = jobDetail.getJobDataMap();
//
//			int currentId = 0;
//
////		      if (map.containsKey("last_id"))
////		       currentId = map.getInt("last_id");
////
////		      for (Map row : data) {
////		       int i = Integer.parseInt(row.get("id").toString());
////		       if (currentId < i)
////		        currentId = i;
////		      }
////		      jobDetail.getJobDataMap().put("last_id", currentId);
//			
//		}
//	    })
//	    .log("last Processed Id: ${header.jobDetail.jobDataMap[last_id]}")
//	    .to("activemq:myQueue");
//
//	  from("activemq:myQueue").marshal().json().to("file:db.output");
//
//	 }
//}

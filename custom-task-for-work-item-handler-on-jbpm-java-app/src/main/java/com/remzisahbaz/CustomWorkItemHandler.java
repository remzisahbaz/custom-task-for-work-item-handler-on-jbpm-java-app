package com.remzisahbaz;

import java.util.*;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
public class CustomWorkItemHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        workItemManager.abortWorkItem(workItem.getId());
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        System.out.println("******************************************CustomWorkItemHandler****************************************");
        Map<String,Object> parameters;
        parameters =  workItem.getParameters();
        parameters.entrySet().forEach(System.out::println);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("Result", "Executed CustomWIH successfully by remzisahbaz ");
        workItemManager.completeWorkItem(workItem.getId(), resultMap);
    }
}

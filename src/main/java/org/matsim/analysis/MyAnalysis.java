package org.matsim.analysis;

import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class MyAnalysis {
    public static void main(String[] args) {
        EventsManager manager = EventsUtils.createEventsManager();
//        manager.addHandler(new MyEventsHandler());
        MyEventsHandler eventHandler = new MyEventsHandler();
        manager.addHandler(eventHandler);

        EventsUtils.readEvents(manager,"scenarios/serengeti-park-v1.0/output/output-serengeti-park-v1.0-run1/serengeti-park-v1.0-run1.output_events.xml.gz");
        System.out.println("Count is: " + eventHandler.count);
    }
    static class MyEventsHandler implements LinkLeaveEventHandler {
        public int count=0;

        @Override
        public void handleEvent(LinkLeaveEvent linkLeaveEvent){
            count++;
    //        System.out.println(linkLeaveEvent.getLinkId());
        }
    }
}

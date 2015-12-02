/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskplanner;

import java.util.Comparator;

/**
 *
 * @author pc109
 */
public class SortEventsAscending implements Comparator<Event>{
     @Override
        public int compare(Event o1, Event o2) {
            return (o1.getPriority()>o2.getPriority() ? -1 : (o1.getPriority()==o2.getPriority() ? 0 : 1));
	}   
}

package net.jcip.examples;

import java.io.Console;
import java.util.*;

import net.jcip.annotations.*;

/**
 * ThreeStooges
 * <p/>
 * Immutable class built out of mutable underlying objects,
 * demonstration of candidate for lock elision
 *
 * @author Brian Goetz and Tim Peierls
 */
@Immutable
 public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    public String getStoogeNames() {
        //List<String> stooges = new Vector<String>();
        stooges.add("Moe2");
        stooges.add("Larry2");
        stooges.add("Curly2");
        return stooges.toString();
    }
    
    public static void main(String[] args) {
		
    	ThreeStooges threeStooges = new ThreeStooges();
    	System.out.println(threeStooges.getStoogeNames()); 
	}
}

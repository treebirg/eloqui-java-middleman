package com.thalmic.myo.example;

import com.thalmic.myo.enums.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alex on 22.11.2014.
 */
public class ComparatorClass {


    private ArrayList<ArrayList<MyoState>> myoPatterns = new ArrayList<ArrayList<MyoState>>();
    private HashMap<ArrayList<MyoState>, String> messageHashMap = new HashMap<ArrayList<MyoState>, String>();

    public ComparatorClass()
    {
        // Hard coded patterns for testing.
        ArrayList<MyoState> pattern = new ArrayList<MyoState>();

        /////////////
        // Right arm.


        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_RIGHT,
                PoseType.WAVE_IN,
                Rotation.NORMAL,
                Direction.MEDIUM,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "we are");

        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_RIGHT,
                PoseType.WAVE_IN,
                Rotation.NORMAL,
                Direction.UP,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "voice");

        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_RIGHT,
                PoseType.FINGERS_SPREAD,
                Rotation.NORMAL,
                Direction.DOWN,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "from");

        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_RIGHT,
                PoseType.FIST,
                Rotation.NORMAL,
                Direction.MEDIUM,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "will have");













        ////////////
        // Left arm.






        pattern.add(new MyoState(Arm.ARM_LEFT,
                PoseType.FINGERS_SPREAD,
                Rotation.NORMAL,
                Direction.MEDIUM,
                Orientation.OUTWARDS));

        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "Hi!");

        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_LEFT,
                PoseType.WAVE_OUT,
                Rotation.NORMAL,
                Direction.MEDIUM,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "now on");


        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_LEFT,
                PoseType.WAVE_IN,
                Rotation.NORMAL,
                Direction.MEDIUM,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "persons");


        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_LEFT,
                PoseType.FIST,
                Rotation.NORMAL,
                Direction.UP,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "awesome");


        pattern = new ArrayList<MyoState>();
        pattern.add(new MyoState(Arm.ARM_LEFT,
                PoseType.WAVE_IN,
                Rotation.NORMAL,
                Direction.UP,
                Orientation.OUTWARDS
        ));
        myoPatterns.add(pattern);
        messageHashMap.put(pattern, "this");










    }

    public void compare(ArrayList<MyoState> myoStatePattern){

        for(int i=0;i<myoPatterns.size();i++){
        //    System.out.println("Size of  pattern: " + poses.get(i).size());
        //    System.out.println("Size of argPattenr: " + argPattern.size());
            if(myoStatePattern.size() == myoPatterns.get(i).size()){
                // System.out.println("There is a possible pattern ");
                int j;
                for(j=0; j<myoStatePattern.size(); j++){
                    if(!myoStatePattern.get(j).equals(myoPatterns.get(i).get(j))){
                        break;
                    }
                }
                if(j==myoStatePattern.size()){
                    String message = messageHashMap.get(myoPatterns.get(i));
                    System.out.println(message);
                    Server.addStringToQueue(message);
                    // System.out.printf("Pattern found!");
                   // System.out.println(myoStatePattern.get(j).getPoseType().toString());
                }
            }

        }
        myoStatePattern.clear();
    }
}





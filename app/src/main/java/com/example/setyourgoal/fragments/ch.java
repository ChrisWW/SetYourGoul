////package com.example.setyourgoal.fragments;
////
////import android.widget.Chronometer;
////
////public class ch {
////    private Chronometer chronometer;
////    private boolean running;
////
////    public void startChronometer(View v) {
////        if (!running) {
////            chronometer.start();
////            running = true;
////        }
////
////    }
////
////    public void stopChronometer(View v) {
////        if (running) {
////            chronometer.stop();
////            running = false;
////        }
////
////    }
////
////    public void resetChronometer(View v) {
////
////
////    }
////}
//
//
//chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()) {
//@Override
//public void onChronometerTick(Chronmeter chronometer) {
//        if ((SystemClock.elapsedRealtime() - chronometer.getBase() >= 10000)) {
//        chronometer.setBase(SystemClock.elapsedRealtime())
//        Toast.makeText(this, "Bing!", Toast.LENGTH_SHORT).show()
//        }
//        }
//        }
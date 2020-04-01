package com.example.benchmarkos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class app {
    public void emptyapp(){}

    public void  memoryblock(){
        String Text = "hello, this is OS benchmark tool";

    }



}
public class MainActivity extends AppCompatActivity {

    public class ThreadBench extends Thread {
        public void run() {
        }
    }
    public void exec1(View view){
            TextView text1 = (TextView) findViewById(R.id.disp1);
            TextView text2 = (TextView) findViewById(R.id.disp11);
            text1.setText("Running....");
            char[] animationChar = { '|', '/', '-', '\\' };
            long startTime = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                text1.setText("Processing: " + (i / 1000) + "%" + animationChar[i % 4] + "\r");
                ThreadBench t = new ThreadBench();
                t.start();
            }
            long endTime = System.nanoTime();
            long total = endTime - startTime;
            double totalSec = (total / 1000000000L);
            text1.setText("Time taken create and destroy 10000 threads = " + total + " ns or " + totalSec + " sec");
            text2.setText("Time taken to create and destroy 1 thread = " + (total / 10000.0D) + " ns or " + (totalSec / 10000.0D) + " sec");

        }



    public void exec2(View view){
        TextView text1 = (TextView) findViewById(R.id.disp2);
        TextView text2 = (TextView) findViewById(R.id.disp22);
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            text1.setText("Processing: " + (i / 5) + "%" + animationChar[i % 4] + "\r");
                try {
                    ProcessBuilder builder = new ProcessBuilder(new String[] { "print" });
                    Process process = builder.start();
                    process.destroy();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken create and destroy 1000 Process = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to create and destroy 1 Process = " + (total / 1000.0D) + " ns or " + (totalSec / 1000.0D) + " sec");

    }
    public void exec3(View view){
        TextView text1 = (TextView) findViewById(R.id.disp3);
        TextView text2 = (TextView) findViewById(R.id.disp33);
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            text1.setText("Processing: " + i + "%" + animationChar[i % 4] + "\r");
            app e = new app();
            e.emptyapp();
        }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken to run 100000 empty apps = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to run 1 empty app = " + (total / 100000.0D) + " ns or " + (totalSec / 100000.0D) + " sec");

    }

    public void exec4(View view){
        TextView text1 = (TextView) findViewById(R.id.disp4);
        TextView text2 = (TextView) findViewById(R.id.disp44);
        String data = "hello, this is OS benchmark tool";
        FileOutputStream out = null;
        File file = new File("C:\\test\\");
        boolean bool = file.mkdirs();
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            text1.setText("Processing: " + (i / 100000) + "%" + animationChar[i % 4] + "\r");
            try {
                out = new FileOutputStream("C:\\test\\testFile" + i + ".txt");
                out.write(data.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken to create and enter 32byte data in 10000 txt files = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to create and enter 32byte data in 1 txt files = " + (total / 10000.0D) + " ns or " + (totalSec / 10000.0D) + " sec");
        exec5();

    }
    public void exec5(){
        TextView text1 = (TextView) findViewById(R.id.disp5);
        TextView text2 = (TextView) findViewById(R.id.disp55);
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            text1.setText("Processing: " + (i / 10000) + "%" + animationChar[i % 4] + "\r");
            try {
                File f = new File("C:\\test\\testFile" + i + ".txt");
                boolean bool = f.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken to delete 10000 txt files = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to delete 1 txt files = " + (total / 10000.0D) + " ns or " + (totalSec / 10000.0D) + " sec");

    }
    public void exec6(View view){
        TextView text1 = (TextView) findViewById(R.id.disp6);
        TextView text2 = (TextView) findViewById(R.id.disp66);
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            text1.setText("Processing: " + (i / 10000) + "%" + animationChar[i % 4] + "\r");
            app mb = new app();
            mb.memoryblock();
        }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken to Allocate 100000 memory blocks of size 32 Bytes = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to Allocate 1 memory blocks of size 32 Bytes= " + (total / 100000.0D) + " ns or " + (totalSec / 100000.0D) + " sec");

    }public void exec7(View view){
        TextView text1 = (TextView) findViewById(R.id.disp7);
        TextView text2 = (TextView) findViewById(R.id.disp77);
        text1.setText("Running....");
        char[] animationChar = { '|', '/', '-', '\\' };
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            text1.setText("Processing: " + i + "%" + animationChar[i % 4] + "\r");
            try {
                Process process = Runtime.getRuntime().exec("javac app.java");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        long total = endTime - startTime;
        double totalSec = (total / 1000000000L);
        text1.setText("Time taken to compile 10000 java files = " + total + " ns or " + totalSec + " sec");
        text2.setText("Time taken to compile 1 java file = " + (total / 1000.0D) + " ns or " + (totalSec / 1000.0D) + " sec");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

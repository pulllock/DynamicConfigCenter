package me.cxis.dcc;

import org.junit.Test;

public class DCCTest {

    @Test
    public void testGet() {
        System.out.println(DCC.get("TestProject.user.prefix"));

        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(DCC.get("TestProject.user.prefix"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

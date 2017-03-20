package com.cai.zkdemo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by reason on 17/3/20.
 */
public class ZkConnectWithSession {
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = ZkSimpleConnect.getZk();
        byte[] sessionPasswd = zk.getSessionPasswd();
        long sessionId = zk.getSessionId();

        ZooKeeper zooKeeper = new ZooKeeper("182.92.234.61:2181", 5000, new ZkSimpleConnect(), sessionId+2, sessionPasswd);

        ZooKeeper zooKeeper2 = new ZooKeeper("182.92.234.61:2181", 5000, new ZkSimpleConnect(), sessionId, sessionPasswd);
        Thread.sleep(Integer.MAX_VALUE);

    }


}

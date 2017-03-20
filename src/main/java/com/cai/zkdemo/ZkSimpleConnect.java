package com.cai.zkdemo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by reason on 17/3/20.
 */
public class ZkSimpleConnect implements Watcher{
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static void main(String[] args) throws IOException {
      getZk();

    }
    public void process(WatchedEvent watchedEvent) {
        System.out.println("获得的watched事件："+watchedEvent);
        if(watchedEvent.getState()== Event.KeeperState.SyncConnected){
            connectedSemaphore.countDown();
        }
    }

    public static ZooKeeper getZk() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("182.92.234.61:2181", 5000, new ZkSimpleConnect());
        System.out.println("正在连接zk，状态"+zooKeeper.getState());

        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("成功连接zk");
        return zooKeeper;
    }
}

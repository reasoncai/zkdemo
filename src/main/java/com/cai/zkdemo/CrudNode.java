package com.cai.zkdemo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by reason on 17/3/20.
 */
public class CrudNode {
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        createNodeSync();
    }

    public static void createNodeSync() throws KeeperException, InterruptedException, IOException {
        ZooKeeper zk = ZkSimpleConnect.getZk();
        String n1 = zk.create("/zk-test-ephemeral-", "n1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("node1: "+n1);
        String n2 = zk.create("/zk-test-ephemeral-", "n2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("node2: "+n2);
        Thread.sleep(Integer.MAX_VALUE);

    }
}

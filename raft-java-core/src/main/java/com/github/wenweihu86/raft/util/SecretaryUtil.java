package com.github.wenweihu86.raft.util;

import com.github.wenweihu86.raft.Peer;
import com.github.wenweihu86.raft.RaftNode;
import com.github.wenweihu86.raft.RaftOptions;

import java.util.concurrent.ConcurrentMap;

public class SecretaryUtil {
    public static Peer getSecretary(ConcurrentMap<Integer, Peer> peerMap, RaftNode raftNode) {
        for(Peer peer : peerMap.values()){
            if(peer.getServer().getServerId() != raftNode.getLeaderId()){
                return peer;
            }
        }
        return null;
    }
}

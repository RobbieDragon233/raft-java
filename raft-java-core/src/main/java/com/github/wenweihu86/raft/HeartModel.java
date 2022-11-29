package com.github.wenweihu86.raft;

import java.util.HashMap;
import java.util.Map;

public class HeartModel {

    private static Map<Peer, Long> heartInterval = new HashMap<>();

    public static long getDelayTimer(Peer peer, RaftOptions raftOptions) {
        final Long preBeatTime = heartInterval.getOrDefault(peer, raftOptions.getMinBeatTime());
        return calculator(peer, raftOptions, preBeatTime);
    }

    private static Long calculator(Peer peer, RaftOptions raftOptions, Long preBeatTime) {
        Long checkBeatTime = preBeatTime + raftOptions.getTimeInterval();
        if (checkBeatTime > raftOptions.getMaxBeatTime()) {
            checkBeatTime = Math.max(checkBeatTime / 2, raftOptions.getMinBeatTime());
        }
        return checkBeatTime;
    }

}

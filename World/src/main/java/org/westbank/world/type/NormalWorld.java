package org.westbank.world.type;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import org.westbank.world.World;
import org.westbank.world.WorldStatus;
import org.westbank.world.WorldType;

/**
 * Created by Jacob on 11/30/2016.
 */
public class NormalWorld extends World {

    public NormalWorld() {
        super(1, "127.0.0.1:43594", WorldStatus.BETA);
    }


}

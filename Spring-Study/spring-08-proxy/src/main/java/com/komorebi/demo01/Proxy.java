package com.komorebi.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proxy implements Rent {
    private Host host;

    public void rent(){
        host.rent();
    }

    public void seeHouse(){
        System.out.println("See the house.");
    }
}

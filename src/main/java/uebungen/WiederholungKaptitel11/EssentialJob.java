package uebungen.WiederholungKaptitel11;

import uebungen.Kapitel10BesondereTypen.Job;

public enum EssentialJob implements jobs {

    CAPTAIN, QUARTERMASTER, SAILINGMASTER, BOATSWAIN, SURGEON, CARPENTER, MASTER_GUNNER;



}

enum NonEssentialJob implements jobs {
    MATE, ABLE_BODIED_SAILOR, CABIN_BOY;
}

interface jobs  {
    
}




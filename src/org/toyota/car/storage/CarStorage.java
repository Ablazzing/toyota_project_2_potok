package org.toyota.car.storage;

import org.toyota.car.models.Camry;
import org.toyota.car.models.Dyna;
import org.toyota.car.models.Hiance;
import org.toyota.car.models.Solara;

public class CarStorage {
    private int size = 0;
    private Camry[] camryArray = new Camry[1000];
    private Solara[] solaraArray = new Solara[1000];
    private Hiance[] hianceArray = new Hiance[1000];
    private Dyna[] dynaArray = new Dyna[1000];
    private int camryArraySize = 0;
    private int solaraArraySize = 0;
    private int hianceArraySize = 0;
    private int dynaArraySize = 0;
    
    public void addCamry(Camry camry) {
        if (size < 1000) {
            camryArray[camryArraySize++] = camry;
            size++;
        }
    }

    public void addSolara(Solara solara) {
        if (size < 1000) {
            solaraArray[solaraArraySize++] = solara;
            size++;
        }
    }
    
    public void addHiance(Hiance hiance) {
        if (size < 1000) {
            hianceArray[hianceArraySize++] = hiance;
            size++;
        }
    }
    
    public void addDyna(Dyna dyna) {
        if (size < 1000) {
            dynaArray[dynaArraySize++] = dyna;
            size++;
        }
    }

    public Camry getCamry() throws CarNotExistException {
        if (camryArraySize > 0) {
            return camryArray[--camryArraySize];
        }
        throw new CarNotExistException("Camry нет на складе");
    }

    public Solara getSolara() throws CarNotExistException {
        if (solaraArraySize > 0) {
            return solaraArray[--solaraArraySize];
        }
        throw new CarNotExistException("Solara нет на складе");
    }

    public Dyna getDyna() throws CarNotExistException {
        if (dynaArraySize > 0) {
            return dynaArray[--dynaArraySize];
        }
        throw new CarNotExistException("Dyna нет на складе");
    }

    public Hiance getHiance() throws CarNotExistException {
        if (hianceArraySize > 0) {
            return hianceArray[--hianceArraySize];
        }
        throw new CarNotExistException("Hiance нет на складе");
    }

    public int getCamryArraySize() {
        return camryArraySize;
    }

    public int getSolaraArraySize() {
        return solaraArraySize;
    }

    public int getHianceArraySize() {
        return hianceArraySize;
    }

    public int getDynaArraySize() {
        return dynaArraySize;
    }
}

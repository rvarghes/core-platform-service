package com.kcdata.abe.bapi.util;
public class Ynearby_AirportType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2050987810L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YNEARBY_AIRPORT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Ynearby_AirportType.class, new com.kcdata.abe.bapi.Ynearby_AirportType(), new java.lang.String[][]{}, 11, 22, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YNEARBY_AIRPORT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Gateway Destination Near by Airport Codes</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>11</ifr:internalLength1><ifr:internalLength2>22</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Ynearby_AirportType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int lastIndexOfYnearby_AirportType(com.kcdata.abe.bapi.Ynearby_AirportType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfYnearby_AirportType(com.kcdata.abe.bapi.Ynearby_AirportType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Ynearby_AirportType removeYnearby_AirportType(int index) {
        return (com.kcdata.abe.bapi.Ynearby_AirportType)baseList().remove(index);
    }

    public boolean removeYnearby_AirportType(com.kcdata.abe.bapi.Ynearby_AirportType item) {
        return baseList().remove(item);
    }

    public void addYnearby_AirportType(com.kcdata.abe.bapi.Ynearby_AirportType item) {
        baseList().add(item);
    }

    public boolean containsYnearby_AirportType(com.kcdata.abe.bapi.Ynearby_AirportType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Ynearby_AirportType setYnearby_AirportType(int index, com.kcdata.abe.bapi.Ynearby_AirportType item) {
        return (com.kcdata.abe.bapi.Ynearby_AirportType)baseList().set(index, item);
    }

    public void addYnearby_AirportType(int index, com.kcdata.abe.bapi.Ynearby_AirportType item) {
        baseList().add(index, item);
    }

    public Ynearby_AirportType_List subListYnearby_AirportType(int fromIndex, int toIndex) {
        return (Ynearby_AirportType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYnearby_AirportType(int index, Ynearby_AirportType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Ynearby_AirportType[] toArrayYnearby_AirportType() {
        return (com.kcdata.abe.bapi.Ynearby_AirportType[])baseList().toArray(new com.kcdata.abe.bapi.Ynearby_AirportType[] {});
    }

    public void addAllYnearby_AirportType(Ynearby_AirportType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYnearby_AirportType(Ynearby_AirportType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Ynearby_AirportType getYnearby_AirportType(int index) {
        return (com.kcdata.abe.bapi.Ynearby_AirportType)baseList().get(index);
    }

}

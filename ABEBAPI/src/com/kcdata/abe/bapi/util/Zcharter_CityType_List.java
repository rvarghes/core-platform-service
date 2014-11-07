package com.kcdata.abe.bapi.util;
public class Zcharter_CityType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1684428685L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZCHARTER_CITY", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zcharter_CityType.class, new com.kcdata.abe.bapi.Zcharter_CityType(), new java.lang.String[][]{}, 24, 48, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZCHARTER_CITY\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get City Pair for Charter material</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>24</ifr:internalLength1><ifr:internalLength2>48</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zcharter_CityType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zcharter_CityType setZcharter_CityType(int index, com.kcdata.abe.bapi.Zcharter_CityType item) {
        return (com.kcdata.abe.bapi.Zcharter_CityType)baseList().set(index, item);
    }

    public boolean removeZcharter_CityType(com.kcdata.abe.bapi.Zcharter_CityType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Zcharter_CityType getZcharter_CityType(int index) {
        return (com.kcdata.abe.bapi.Zcharter_CityType)baseList().get(index);
    }

    public boolean containsZcharter_CityType(com.kcdata.abe.bapi.Zcharter_CityType item) {
        return baseList().contains(item);
    }

    public Zcharter_CityType_List subListZcharter_CityType(int fromIndex, int toIndex) {
        return (Zcharter_CityType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZcharter_CityType(int index, com.kcdata.abe.bapi.Zcharter_CityType item) {
        baseList().add(index, item);
    }

    public void addZcharter_CityType(com.kcdata.abe.bapi.Zcharter_CityType item) {
        baseList().add(item);
    }

    public boolean containsAllZcharter_CityType(Zcharter_CityType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllZcharter_CityType(int index, Zcharter_CityType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllZcharter_CityType(Zcharter_CityType_List item) {
        baseList().addAll(item);
    }

    public int indexOfZcharter_CityType(com.kcdata.abe.bapi.Zcharter_CityType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zcharter_CityType[] toArrayZcharter_CityType() {
        return (com.kcdata.abe.bapi.Zcharter_CityType[])baseList().toArray(new com.kcdata.abe.bapi.Zcharter_CityType[] {});
    }

    public com.kcdata.abe.bapi.Zcharter_CityType removeZcharter_CityType(int index) {
        return (com.kcdata.abe.bapi.Zcharter_CityType)baseList().remove(index);
    }

    public int lastIndexOfZcharter_CityType(com.kcdata.abe.bapi.Zcharter_CityType item) {
        return baseList().lastIndexOf(item);
    }

}

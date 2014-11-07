package com.kcdata.abe.bapi.util;
public class Ztrackitin_PaxType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 2024999523L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZTRACKITIN_PAX", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Ztrackitin_PaxType.class, new com.kcdata.abe.bapi.Ztrackitin_PaxType(), new java.lang.String[][]{}, 93, 186, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZTRACKITIN_PAX\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Customer E-mail tracking table</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>93</ifr:internalLength1><ifr:internalLength2>186</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Ztrackitin_PaxType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType setZtrackitin_PaxType(int index, com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        return (com.kcdata.abe.bapi.Ztrackitin_PaxType)baseList().set(index, item);
    }

    public void addZtrackitin_PaxType(int index, com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        baseList().add(index, item);
    }

    public void addAllZtrackitin_PaxType(Ztrackitin_PaxType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZtrackitin_PaxType(com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZtrackitin_PaxType(Ztrackitin_PaxType_List item) {
        return baseList().containsAll(item);
    }

    public void addZtrackitin_PaxType(com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        baseList().add(item);
    }

    public void addAllZtrackitin_PaxType(int index, Ztrackitin_PaxType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsZtrackitin_PaxType(com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType getZtrackitin_PaxType(int index) {
        return (com.kcdata.abe.bapi.Ztrackitin_PaxType)baseList().get(index);
    }

    public int lastIndexOfZtrackitin_PaxType(com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType[] toArrayZtrackitin_PaxType() {
        return (com.kcdata.abe.bapi.Ztrackitin_PaxType[])baseList().toArray(new com.kcdata.abe.bapi.Ztrackitin_PaxType[] {});
    }

    public Ztrackitin_PaxType_List subListZtrackitin_PaxType(int fromIndex, int toIndex) {
        return (Ztrackitin_PaxType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Ztrackitin_PaxType removeZtrackitin_PaxType(int index) {
        return (com.kcdata.abe.bapi.Ztrackitin_PaxType)baseList().remove(index);
    }

    public int indexOfZtrackitin_PaxType(com.kcdata.abe.bapi.Ztrackitin_PaxType item) {
        return baseList().indexOf(item);
    }

}

package com.kcdata.abe.bapi.util;
public class Ztrackitin_TaType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 178801957L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZTRACKITIN_TA", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Ztrackitin_TaType.class, new com.kcdata.abe.bapi.Ztrackitin_TaType(), new java.lang.String[][]{}, 87, 174, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZTRACKITIN_TA\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Travel agent E-mail tracking table</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>87</ifr:internalLength1><ifr:internalLength2>174</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Ztrackitin_TaType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addZtrackitin_TaType(com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        baseList().add(item);
    }

    public boolean containsZtrackitin_TaType(com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType getZtrackitin_TaType(int index) {
        return (com.kcdata.abe.bapi.Ztrackitin_TaType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType setZtrackitin_TaType(int index, com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        return (com.kcdata.abe.bapi.Ztrackitin_TaType)baseList().set(index, item);
    }

    public void addZtrackitin_TaType(int index, com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        baseList().add(index, item);
    }

    public void addAllZtrackitin_TaType(int index, Ztrackitin_TaType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllZtrackitin_TaType(Ztrackitin_TaType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZtrackitin_TaType(Ztrackitin_TaType_List item) {
        return baseList().containsAll(item);
    }

    public int lastIndexOfZtrackitin_TaType(com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType[] toArrayZtrackitin_TaType() {
        return (com.kcdata.abe.bapi.Ztrackitin_TaType[])baseList().toArray(new com.kcdata.abe.bapi.Ztrackitin_TaType[] {});
    }

    public com.kcdata.abe.bapi.Ztrackitin_TaType removeZtrackitin_TaType(int index) {
        return (com.kcdata.abe.bapi.Ztrackitin_TaType)baseList().remove(index);
    }

    public int indexOfZtrackitin_TaType(com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        return baseList().indexOf(item);
    }

    public Ztrackitin_TaType_List subListZtrackitin_TaType(int fromIndex, int toIndex) {
        return (Ztrackitin_TaType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeZtrackitin_TaType(com.kcdata.abe.bapi.Ztrackitin_TaType item) {
        return baseList().remove(item);
    }

}

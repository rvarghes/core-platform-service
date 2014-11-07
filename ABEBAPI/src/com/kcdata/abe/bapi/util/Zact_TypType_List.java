package com.kcdata.abe.bapi.util;
public class Zact_TypType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2090028802L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZACT_TYP", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zact_TypType.class, new com.kcdata.abe.bapi.Zact_TypType(), new java.lang.String[][]{}, 32, 64, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZACT_TYP\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Action Types.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>32</ifr:internalLength1><ifr:internalLength2>64</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zact_TypType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public Zact_TypType_List subListZact_TypType(int fromIndex, int toIndex) {
        return (Zact_TypType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfZact_TypType(com.kcdata.abe.bapi.Zact_TypType item) {
        return baseList().lastIndexOf(item);
    }

    public void addZact_TypType(int index, com.kcdata.abe.bapi.Zact_TypType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zact_TypType[] toArrayZact_TypType() {
        return (com.kcdata.abe.bapi.Zact_TypType[])baseList().toArray(new com.kcdata.abe.bapi.Zact_TypType[] {});
    }

    public boolean removeZact_TypType(com.kcdata.abe.bapi.Zact_TypType item) {
        return baseList().remove(item);
    }

    public int indexOfZact_TypType(com.kcdata.abe.bapi.Zact_TypType item) {
        return baseList().indexOf(item);
    }

    public void addAllZact_TypType(Zact_TypType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZact_TypType(Zact_TypType_List item) {
        return baseList().containsAll(item);
    }

    public boolean containsZact_TypType(com.kcdata.abe.bapi.Zact_TypType item) {
        return baseList().contains(item);
    }

    public void addAllZact_TypType(int index, Zact_TypType_List item) {
        baseList().addAll(index, item);
    }

    public void addZact_TypType(com.kcdata.abe.bapi.Zact_TypType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zact_TypType removeZact_TypType(int index) {
        return (com.kcdata.abe.bapi.Zact_TypType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zact_TypType setZact_TypType(int index, com.kcdata.abe.bapi.Zact_TypType item) {
        return (com.kcdata.abe.bapi.Zact_TypType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Zact_TypType getZact_TypType(int index) {
        return (com.kcdata.abe.bapi.Zact_TypType)baseList().get(index);
    }

}

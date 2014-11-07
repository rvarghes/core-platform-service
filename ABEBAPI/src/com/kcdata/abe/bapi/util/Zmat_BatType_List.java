package com.kcdata.abe.bapi.util;
public class Zmat_BatType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1264184234L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZMAT_BAT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zmat_BatType.class, new com.kcdata.abe.bapi.Zmat_BatType(), new java.lang.String[][]{}, 61, 102, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZMAT_BAT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Material/S.Loc/Batch</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>61</ifr:internalLength1><ifr:internalLength2>102</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zmat_BatType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zmat_BatType getZmat_BatType(int index) {
        return (com.kcdata.abe.bapi.Zmat_BatType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Zmat_BatType setZmat_BatType(int index, com.kcdata.abe.bapi.Zmat_BatType item) {
        return (com.kcdata.abe.bapi.Zmat_BatType)baseList().set(index, item);
    }

    public void addZmat_BatType(int index, com.kcdata.abe.bapi.Zmat_BatType item) {
        baseList().add(index, item);
    }

    public void addAllZmat_BatType(Zmat_BatType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZmat_BatType(com.kcdata.abe.bapi.Zmat_BatType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZmat_BatType(Zmat_BatType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Zmat_BatType[] toArrayZmat_BatType() {
        return (com.kcdata.abe.bapi.Zmat_BatType[])baseList().toArray(new com.kcdata.abe.bapi.Zmat_BatType[] {});
    }

    public void addZmat_BatType(com.kcdata.abe.bapi.Zmat_BatType item) {
        baseList().add(item);
    }

    public void addAllZmat_BatType(int index, Zmat_BatType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsZmat_BatType(com.kcdata.abe.bapi.Zmat_BatType item) {
        return baseList().contains(item);
    }

    public Zmat_BatType_List subListZmat_BatType(int fromIndex, int toIndex) {
        return (Zmat_BatType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zmat_BatType removeZmat_BatType(int index) {
        return (com.kcdata.abe.bapi.Zmat_BatType)baseList().remove(index);
    }

    public int lastIndexOfZmat_BatType(com.kcdata.abe.bapi.Zmat_BatType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfZmat_BatType(com.kcdata.abe.bapi.Zmat_BatType item) {
        return baseList().indexOf(item);
    }

}

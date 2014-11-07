package com.kcdata.abe.bapi.util;
public class ZcargType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 532398919L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZCARG", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZcargType.class, new com.kcdata.abe.bapi.ZcargType(), new java.lang.String[][]{}, 68, 136, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZCARG\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Car matrix for storing upgrade info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>68</ifr:internalLength1><ifr:internalLength2>136</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZcargType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public ZcargType_List subListZcargType(int fromIndex, int toIndex) {
        return (ZcargType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeZcargType(com.kcdata.abe.bapi.ZcargType item) {
        return baseList().remove(item);
    }

    public void addZcargType(com.kcdata.abe.bapi.ZcargType item) {
        baseList().add(item);
    }

    public void addAllZcargType(int index, ZcargType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.ZcargType getZcargType(int index) {
        return (com.kcdata.abe.bapi.ZcargType)baseList().get(index);
    }

    public boolean containsZcargType(com.kcdata.abe.bapi.ZcargType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.ZcargType setZcargType(int index, com.kcdata.abe.bapi.ZcargType item) {
        return (com.kcdata.abe.bapi.ZcargType)baseList().set(index, item);
    }

    public void addZcargType(int index, com.kcdata.abe.bapi.ZcargType item) {
        baseList().add(index, item);
    }

    public void addAllZcargType(ZcargType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZcargType(ZcargType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.ZcargType[] toArrayZcargType() {
        return (com.kcdata.abe.bapi.ZcargType[])baseList().toArray(new com.kcdata.abe.bapi.ZcargType[] {});
    }

    public int lastIndexOfZcargType(com.kcdata.abe.bapi.ZcargType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.ZcargType removeZcargType(int index) {
        return (com.kcdata.abe.bapi.ZcargType)baseList().remove(index);
    }

    public int indexOfZcargType(com.kcdata.abe.bapi.ZcargType item) {
        return baseList().indexOf(item);
    }

}

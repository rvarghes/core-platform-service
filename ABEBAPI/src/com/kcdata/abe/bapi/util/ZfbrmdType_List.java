package com.kcdata.abe.bapi.util;
public class ZfbrmdType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 125369613L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZFBRMD", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZfbrmdType.class, new com.kcdata.abe.bapi.ZfbrmdType(), new java.lang.String[][]{}, 523, 1046, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZFBRMD\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Booking - Vendor(s) RFA details for display (FE)</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>523</ifr:internalLength1><ifr:internalLength2>1046</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZfbrmdType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.ZfbrmdType setZfbrmdType(int index, com.kcdata.abe.bapi.ZfbrmdType item) {
        return (com.kcdata.abe.bapi.ZfbrmdType)baseList().set(index, item);
    }

    public ZfbrmdType_List subListZfbrmdType(int fromIndex, int toIndex) {
        return (ZfbrmdType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZfbrmdType(int index, com.kcdata.abe.bapi.ZfbrmdType item) {
        baseList().add(index, item);
    }

    public void addAllZfbrmdType(ZfbrmdType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZfbrmdType(com.kcdata.abe.bapi.ZfbrmdType item) {
        return baseList().remove(item);
    }

    public boolean containsAllZfbrmdType(ZfbrmdType_List item) {
        return baseList().containsAll(item);
    }

    public void addZfbrmdType(com.kcdata.abe.bapi.ZfbrmdType item) {
        baseList().add(item);
    }

    public void addAllZfbrmdType(int index, ZfbrmdType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.ZfbrmdType removeZfbrmdType(int index) {
        return (com.kcdata.abe.bapi.ZfbrmdType)baseList().remove(index);
    }

    public boolean containsZfbrmdType(com.kcdata.abe.bapi.ZfbrmdType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.ZfbrmdType[] toArrayZfbrmdType() {
        return (com.kcdata.abe.bapi.ZfbrmdType[])baseList().toArray(new com.kcdata.abe.bapi.ZfbrmdType[] {});
    }

    public int lastIndexOfZfbrmdType(com.kcdata.abe.bapi.ZfbrmdType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.ZfbrmdType getZfbrmdType(int index) {
        return (com.kcdata.abe.bapi.ZfbrmdType)baseList().get(index);
    }

    public int indexOfZfbrmdType(com.kcdata.abe.bapi.ZfbrmdType item) {
        return baseList().indexOf(item);
    }

}

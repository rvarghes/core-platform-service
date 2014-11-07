package com.kcdata.abe.bapi.util;
public class ZapipaxType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 847885569L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPIPAX", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZapipaxType.class, new com.kcdata.abe.bapi.ZapipaxType(), new java.lang.String[][]{}, 512, 1024, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPIPAX\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Passengers mailids</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>512</ifr:internalLength1><ifr:internalLength2>1024</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZapipaxType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.ZapipaxType[] toArrayZapipaxType() {
        return (com.kcdata.abe.bapi.ZapipaxType[])baseList().toArray(new com.kcdata.abe.bapi.ZapipaxType[] {});
    }

    public void addAllZapipaxType(int index, ZapipaxType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllZapipaxType(ZapipaxType_List item) {
        baseList().addAll(item);
    }

    public boolean removeZapipaxType(com.kcdata.abe.bapi.ZapipaxType item) {
        return baseList().remove(item);
    }

    public int lastIndexOfZapipaxType(com.kcdata.abe.bapi.ZapipaxType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.ZapipaxType setZapipaxType(int index, com.kcdata.abe.bapi.ZapipaxType item) {
        return (com.kcdata.abe.bapi.ZapipaxType)baseList().set(index, item);
    }

    public ZapipaxType_List subListZapipaxType(int fromIndex, int toIndex) {
        return (ZapipaxType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addZapipaxType(int index, com.kcdata.abe.bapi.ZapipaxType item) {
        baseList().add(index, item);
    }

    public int indexOfZapipaxType(com.kcdata.abe.bapi.ZapipaxType item) {
        return baseList().indexOf(item);
    }

    public boolean containsZapipaxType(com.kcdata.abe.bapi.ZapipaxType item) {
        return baseList().contains(item);
    }

    public boolean containsAllZapipaxType(ZapipaxType_List item) {
        return baseList().containsAll(item);
    }

    public void addZapipaxType(com.kcdata.abe.bapi.ZapipaxType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.ZapipaxType getZapipaxType(int index) {
        return (com.kcdata.abe.bapi.ZapipaxType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.ZapipaxType removeZapipaxType(int index) {
        return (com.kcdata.abe.bapi.ZapipaxType)baseList().remove(index);
    }

}

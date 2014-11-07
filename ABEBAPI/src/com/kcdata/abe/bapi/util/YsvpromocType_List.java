package com.kcdata.abe.bapi.util;
public class YsvpromocType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1007588362L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YSVPROMOC", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.YsvpromocType.class, new com.kcdata.abe.bapi.YsvpromocType(), new java.lang.String[][]{}, 280, 560, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YSVPROMOC\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Interface for voucher promotion code</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>280</ifr:internalLength1><ifr:internalLength2>560</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  YsvpromocType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllYsvpromocType(int index, YsvpromocType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYsvpromocType(YsvpromocType_List item) {
        baseList().addAll(item);
    }

    public YsvpromocType_List subListYsvpromocType(int fromIndex, int toIndex) {
        return (YsvpromocType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYsvpromocType(com.kcdata.abe.bapi.YsvpromocType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYsvpromocType(YsvpromocType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.YsvpromocType getYsvpromocType(int index) {
        return (com.kcdata.abe.bapi.YsvpromocType)baseList().get(index);
    }

    public boolean removeYsvpromocType(com.kcdata.abe.bapi.YsvpromocType item) {
        return baseList().remove(item);
    }

    public void addYsvpromocType(com.kcdata.abe.bapi.YsvpromocType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.YsvpromocType[] toArrayYsvpromocType() {
        return (com.kcdata.abe.bapi.YsvpromocType[])baseList().toArray(new com.kcdata.abe.bapi.YsvpromocType[] {});
    }

    public boolean containsYsvpromocType(com.kcdata.abe.bapi.YsvpromocType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.YsvpromocType setYsvpromocType(int index, com.kcdata.abe.bapi.YsvpromocType item) {
        return (com.kcdata.abe.bapi.YsvpromocType)baseList().set(index, item);
    }

    public void addYsvpromocType(int index, com.kcdata.abe.bapi.YsvpromocType item) {
        baseList().add(index, item);
    }

    public int lastIndexOfYsvpromocType(com.kcdata.abe.bapi.YsvpromocType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.YsvpromocType removeYsvpromocType(int index) {
        return (com.kcdata.abe.bapi.YsvpromocType)baseList().remove(index);
    }

}

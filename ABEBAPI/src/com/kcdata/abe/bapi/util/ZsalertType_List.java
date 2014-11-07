package com.kcdata.abe.bapi.util;
public class ZsalertType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1103485059L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZSALERT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.ZsalertType.class, new com.kcdata.abe.bapi.ZsalertType(), new java.lang.String[][]{}, 96, 192, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZSALERT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Alert interface</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>96</ifr:internalLength1><ifr:internalLength2>192</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  ZsalertType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int lastIndexOfZsalertType(com.kcdata.abe.bapi.ZsalertType item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfZsalertType(com.kcdata.abe.bapi.ZsalertType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.ZsalertType removeZsalertType(int index) {
        return (com.kcdata.abe.bapi.ZsalertType)baseList().remove(index);
    }

    public boolean removeZsalertType(com.kcdata.abe.bapi.ZsalertType item) {
        return baseList().remove(item);
    }

    public void addZsalertType(com.kcdata.abe.bapi.ZsalertType item) {
        baseList().add(item);
    }

    public boolean containsZsalertType(com.kcdata.abe.bapi.ZsalertType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.ZsalertType setZsalertType(int index, com.kcdata.abe.bapi.ZsalertType item) {
        return (com.kcdata.abe.bapi.ZsalertType)baseList().set(index, item);
    }

    public void addZsalertType(int index, com.kcdata.abe.bapi.ZsalertType item) {
        baseList().add(index, item);
    }

    public ZsalertType_List subListZsalertType(int fromIndex, int toIndex) {
        return (ZsalertType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllZsalertType(int index, ZsalertType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.ZsalertType[] toArrayZsalertType() {
        return (com.kcdata.abe.bapi.ZsalertType[])baseList().toArray(new com.kcdata.abe.bapi.ZsalertType[] {});
    }

    public com.kcdata.abe.bapi.ZsalertType getZsalertType(int index) {
        return (com.kcdata.abe.bapi.ZsalertType)baseList().get(index);
    }

    public void addAllZsalertType(ZsalertType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZsalertType(ZsalertType_List item) {
        return baseList().containsAll(item);
    }

}

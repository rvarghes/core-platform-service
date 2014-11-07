package com.kcdata.abe.bapi.util;
public class YfrfacntType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1869937123L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YFRFACNT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.YfrfacntType.class, new com.kcdata.abe.bapi.YfrfacntType(), new java.lang.String[][]{}, 701, 1402, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YFRFACNT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Vendor Details</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>701</ifr:internalLength1><ifr:internalLength2>1402</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  YfrfacntType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.YfrfacntType setYfrfacntType(int index, com.kcdata.abe.bapi.YfrfacntType item) {
        return (com.kcdata.abe.bapi.YfrfacntType)baseList().set(index, item);
    }

    public void addYfrfacntType(int index, com.kcdata.abe.bapi.YfrfacntType item) {
        baseList().add(index, item);
    }

    public void addAllYfrfacntType(YfrfacntType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYfrfacntType(com.kcdata.abe.bapi.YfrfacntType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYfrfacntType(YfrfacntType_List item) {
        return baseList().containsAll(item);
    }

    public void addYfrfacntType(com.kcdata.abe.bapi.YfrfacntType item) {
        baseList().add(item);
    }

    public void addAllYfrfacntType(int index, YfrfacntType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYfrfacntType(com.kcdata.abe.bapi.YfrfacntType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.YfrfacntType getYfrfacntType(int index) {
        return (com.kcdata.abe.bapi.YfrfacntType)baseList().get(index);
    }

    public int lastIndexOfYfrfacntType(com.kcdata.abe.bapi.YfrfacntType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.YfrfacntType[] toArrayYfrfacntType() {
        return (com.kcdata.abe.bapi.YfrfacntType[])baseList().toArray(new com.kcdata.abe.bapi.YfrfacntType[] {});
    }

    public YfrfacntType_List subListYfrfacntType(int fromIndex, int toIndex) {
        return (YfrfacntType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.YfrfacntType removeYfrfacntType(int index) {
        return (com.kcdata.abe.bapi.YfrfacntType)baseList().remove(index);
    }

    public int indexOfYfrfacntType(com.kcdata.abe.bapi.YfrfacntType item) {
        return baseList().indexOf(item);
    }

}

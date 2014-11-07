package com.kcdata.abe.bapi.util;
public class Yzseat_Info_SType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 2053142677L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YZSEAT_INFO_S", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yzseat_Info_SType.class, new com.kcdata.abe.bapi.Yzseat_Info_SType(), new java.lang.String[][]{}, 184, 356, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YZSEAT_INFO_S\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">seat details</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>184</ifr:internalLength1><ifr:internalLength2>356</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yzseat_Info_SType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addYzseat_Info_SType(com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType[] toArrayYzseat_Info_SType() {
        return (com.kcdata.abe.bapi.Yzseat_Info_SType[])baseList().toArray(new com.kcdata.abe.bapi.Yzseat_Info_SType[] {});
    }

    public boolean containsYzseat_Info_SType(com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType setYzseat_Info_SType(int index, com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        return (com.kcdata.abe.bapi.Yzseat_Info_SType)baseList().set(index, item);
    }

    public void addYzseat_Info_SType(int index, com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType removeYzseat_Info_SType(int index) {
        return (com.kcdata.abe.bapi.Yzseat_Info_SType)baseList().remove(index);
    }

    public void addAllYzseat_Info_SType(int index, Yzseat_Info_SType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYzseat_Info_SType(Yzseat_Info_SType_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllYzseat_Info_SType(Yzseat_Info_SType_List item) {
        return baseList().containsAll(item);
    }

    public Yzseat_Info_SType_List subListYzseat_Info_SType(int fromIndex, int toIndex) {
        return (Yzseat_Info_SType_List)baseList().subList(fromIndex, toIndex);
    }

    public int lastIndexOfYzseat_Info_SType(com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType getYzseat_Info_SType(int index) {
        return (com.kcdata.abe.bapi.Yzseat_Info_SType)baseList().get(index);
    }

    public int indexOfYzseat_Info_SType(com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYzseat_Info_SType(com.kcdata.abe.bapi.Yzseat_Info_SType item) {
        return baseList().remove(item);
    }

}

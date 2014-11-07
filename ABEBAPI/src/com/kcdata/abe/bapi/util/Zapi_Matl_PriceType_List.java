package com.kcdata.abe.bapi.util;
public class Zapi_Matl_PriceType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 756224335L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_MATL_PRICE", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Matl_PriceType.class, new com.kcdata.abe.bapi.Zapi_Matl_PriceType(), new java.lang.String[][]{}, 233, 434, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_MATL_PRICE\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Material Level Prices</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>233</ifr:internalLength1><ifr:internalLength2>434</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Matl_PriceType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType removeZapi_Matl_PriceType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Matl_PriceType)baseList().remove(index);
    }

    public Zapi_Matl_PriceType_List subListZapi_Matl_PriceType(int fromIndex, int toIndex) {
        return (Zapi_Matl_PriceType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfZapi_Matl_PriceType(com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        return baseList().indexOf(item);
    }

    public void addAllZapi_Matl_PriceType(int index, Zapi_Matl_PriceType_List item) {
        baseList().addAll(index, item);
    }

    public boolean removeZapi_Matl_PriceType(com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType[] toArrayZapi_Matl_PriceType() {
        return (com.kcdata.abe.bapi.Zapi_Matl_PriceType[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Matl_PriceType[] {});
    }

    public boolean containsAllZapi_Matl_PriceType(Zapi_Matl_PriceType_List item) {
        return baseList().containsAll(item);
    }

    public void addZapi_Matl_PriceType(int index, com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        baseList().add(index, item);
    }

    public void addAllZapi_Matl_PriceType(Zapi_Matl_PriceType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType setZapi_Matl_PriceType(int index, com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        return (com.kcdata.abe.bapi.Zapi_Matl_PriceType)baseList().set(index, item);
    }

    public int lastIndexOfZapi_Matl_PriceType(com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean containsZapi_Matl_PriceType(com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        return baseList().contains(item);
    }

    public void addZapi_Matl_PriceType(com.kcdata.abe.bapi.Zapi_Matl_PriceType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType getZapi_Matl_PriceType(int index) {
        return (com.kcdata.abe.bapi.Zapi_Matl_PriceType)baseList().get(index);
    }

}

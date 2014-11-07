package com.kcdata.abe.bapi.util;
public class Yzexp_SeatType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 591697058L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YZEXP_SEAT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yzexp_SeatType.class, new com.kcdata.abe.bapi.Yzexp_SeatType(), new java.lang.String[][]{}, 61, 122, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YZEXP_SEAT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Seat information with respect to expired booking</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>false</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>61</ifr:internalLength1><ifr:internalLength2>122</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yzexp_SeatType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yzexp_SeatType setYzexp_SeatType(int index, com.kcdata.abe.bapi.Yzexp_SeatType item) {
        return (com.kcdata.abe.bapi.Yzexp_SeatType)baseList().set(index, item);
    }

    public void addYzexp_SeatType(int index, com.kcdata.abe.bapi.Yzexp_SeatType item) {
        baseList().add(index, item);
    }

    public void addAllYzexp_SeatType(Yzexp_SeatType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYzexp_SeatType(com.kcdata.abe.bapi.Yzexp_SeatType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYzexp_SeatType(Yzexp_SeatType_List item) {
        return baseList().containsAll(item);
    }

    public void addYzexp_SeatType(com.kcdata.abe.bapi.Yzexp_SeatType item) {
        baseList().add(item);
    }

    public void addAllYzexp_SeatType(int index, Yzexp_SeatType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYzexp_SeatType(com.kcdata.abe.bapi.Yzexp_SeatType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yzexp_SeatType getYzexp_SeatType(int index) {
        return (com.kcdata.abe.bapi.Yzexp_SeatType)baseList().get(index);
    }

    public int lastIndexOfYzexp_SeatType(com.kcdata.abe.bapi.Yzexp_SeatType item) {
        return baseList().lastIndexOf(item);
    }

    public Yzexp_SeatType_List subListYzexp_SeatType(int fromIndex, int toIndex) {
        return (Yzexp_SeatType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yzexp_SeatType[] toArrayYzexp_SeatType() {
        return (com.kcdata.abe.bapi.Yzexp_SeatType[])baseList().toArray(new com.kcdata.abe.bapi.Yzexp_SeatType[] {});
    }

    public com.kcdata.abe.bapi.Yzexp_SeatType removeYzexp_SeatType(int index) {
        return (com.kcdata.abe.bapi.Yzexp_SeatType)baseList().remove(index);
    }

    public int indexOfYzexp_SeatType(com.kcdata.abe.bapi.Yzexp_SeatType item) {
        return baseList().indexOf(item);
    }

}

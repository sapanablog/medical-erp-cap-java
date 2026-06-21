namespace medical.erp;

entity Products {
    key ID          : UUID;
        productCode : String(20);
        name        : String(100);
        category    : String(50);
        price       : Decimal(10,2);
        stock       : Integer;
}
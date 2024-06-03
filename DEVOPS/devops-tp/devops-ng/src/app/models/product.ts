export class Product {
  private _id: string = "";
  private _name: string = "";
  private _price: number = 0;

  public get id(): string {
    return this._id;
  }
  
  public set id(v: string) {
    this._id = v;
  }

  public get name(): string {
    return this._name;
  }

  public set name(v: string) {
    this._name = v;
  }
  
  public get price(): number {
    return this._price;
  }

  public set price(v: number) {
    this._price = v;
  }
}

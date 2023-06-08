import {Brand} from "./brand";
import {Category} from "./category";

export interface Watch {
  id?:number;
  name?:string;
  price?:number;
  description?:string;
  dateOfManufacture?:string;
  status?:string;
  imgUrl?:string;
  brand?: Brand;
  category?:Category;
  deleteStatus?:number;
}

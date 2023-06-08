import {Brand} from "./brand";
import {Category} from "./category";

export interface WatchDto {
  name?:string;
  price?:number;
  description?:string;
  dateOfManufacture?:string;
  status?:string;
  imgUrl?:string;
  brandId?: number;
  categoryId?:number;
}

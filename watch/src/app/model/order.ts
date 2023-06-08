import {Watch} from "./watch";

export interface Order {
  id?: number;
  amount?: number;
  watch?: Watch
}


import { Component, OnInit } from "@angular/core";
import {Order} from "../model/order";
import {WatchService} from "../service/watch.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: Order[];
  totalPrice: number = 0;
  checkCart: boolean;
  constructor(private _watchService: WatchService) {
  }

  ngOnInit(): void {
    this.checkCart=true;
    this._watchService.getAllOrder().subscribe(data => {
      if(data.length==0)
      {
        this.checkCart=false
      }
      console.log(this.checkCart)
      this.carts = data;
      for (let i = 0; i < data.length; i++) {
        this.totalPrice += data[i].amount * data[i].watch.price;
      }
    })
  }

  setAmount(id: number, amount: any) {
    if(parseInt(amount)<=0){
      this._watchService.deleteOrder(id).subscribe(data=>{
        this.totalPrice=0;
        this.ngOnInit();
      })
    }
    else {
      console.log(id, amount)
      this._watchService.updateCart(id, parseInt(amount)).subscribe(data => {
        this.totalPrice = 0;
        this.ngOnInit();
      })
    }
  }

  deleteAllOrder() {
    this._watchService.deleteAllOrder().subscribe(data=>{
      console.log("success")
      this.totalPrice=0;
      this.ngOnInit();
    })
  }
}

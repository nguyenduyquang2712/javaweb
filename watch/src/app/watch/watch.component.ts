import { Component, OnInit } from '@angular/core';
import {Watch} from "../model/watch";
import {WatchService} from "../service/watch.service";
import {Brand} from "../model/brand";

@Component({
  selector: 'app-watch',
  templateUrl: './watch.component.html',
  styleUrls: ['./watch.component.css']
})
export class WatchComponent implements OnInit {
  watchList:Watch[]=[];
  inforId:number=0;
  brands: Brand[];
  size: number=1;
  constructor(private _watchService: WatchService) { }

  ngOnInit(): void {
    this._watchService.getAllWatch().subscribe(data=>{

      this.watchList=data;
      console.log(data)
    })
    this._watchService.getAllBrand().subscribe(data=>{
      this.brands=data;
    })
  }

  deleteWatch(id: number) {
    this._watchService.deleteWatch(id).subscribe(data=>{
        this.ngOnInit();
    })
  }

  addToCard(id: number) {
    this._watchService.addWatchToCard(id).subscribe(data=>{
      console.log("success")
    })
  }

  SearchByName(value: string) {
    this._watchService.searchWatch(value).subscribe(data=>{
      console.log(data)
      this.size=1;
      this.watchList=data;
      if(data==null){
        this.size=0;
      }
    })
  }

  searchBrand(id: number) {
    this._watchService.searchBrand(id).subscribe(data=>{
      this.watchList=data;
      this.size=1;
      this.watchList=data;
      if(data==null){
        this.size=0;
      }
    })
  }

  getInfor(id: number) {
    this.inforId=id;
  }
}

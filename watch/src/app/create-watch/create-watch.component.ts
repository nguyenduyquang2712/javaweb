import { Component, OnInit } from '@angular/core';
import {WatchService} from "../service/watch.service";
import {Brand} from "../model/brand";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Category} from "../model/category";

@Component({
  selector: 'app-create-watch',
  templateUrl: './create-watch.component.html',
  styleUrls: ['./create-watch.component.css']
})
export class CreateWatchComponent implements OnInit {
  brands:Brand[]=[];
  categories:Category[];
  newWatch: FormGroup;

  constructor(private _watchService: WatchService,
              private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this._watchService.getAllCategory().subscribe(data=>{
      this.categories=data;
      this._watchService.getAllBrand().subscribe(data=>{
        this.brands=data;
        this.newWatch= this._formBuilder.group({
      id:[''],
      name:[''],
          price:[''],
          description:[''],
          dateOfManufacture:[''],
          status:[''],
          imgUrl:[''],
          brandId:[''],
          categoryId:['']
        })
      })

    })
  }


  submit() {
    console.log(this.newWatch.value)
  this._watchService.createWatch(this.newWatch.value).subscribe(data=>{
    console.log("success")
  })
  }
}

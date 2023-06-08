import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {WatchService} from "../service/watch.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Brand} from "../model/brand";
import {Category} from "../model/category";
import {WatchDto} from "../model/watch-dto";
import {Watch} from "../model/watch";

@Component({
  selector: 'app-edit-watch',
  templateUrl: './edit-watch.component.html',
  styleUrls: ['./edit-watch.component.css']
})
export class EditWatchComponent implements OnInit {
  editWatch: FormGroup
  watchId: number = 0;
  brands: Brand[] = [];
  categories: Category[];
  watch: Watch;
  compareFn(c1: any, c2: any): boolean {
    console.log(c1 && c2 ? c1.id === c2.id : c1 === c2);
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }


  constructor(private _watchService: WatchService,
              private _formBuilder: FormBuilder,
              private _activatedRouter: ActivatedRoute,
              private _route: Router) {
  }

  ngOnInit(): void {
    this._activatedRouter.paramMap.subscribe((paramMap: ParamMap) => {
      this.watchId = +paramMap.get("id");
      this._watchService.getWatchById(this.watchId).subscribe(data=>{
this.watch = data;
      })

      this._watchService.getAllCategory().subscribe(data => {
        this.categories = data;
        this._watchService.getAllBrand().subscribe(data => {
          this.brands = data;
          this.editWatch = this._formBuilder.group({
            id: [this.watch.id],
            name: [this.watch.name],
            price: [this.watch.price],
            description: [this.watch.description],
            dateOfManufacture: [this.watch.dateOfManufacture],
            status: [this.watch.status],
            imgUrl: [this.watch.imgUrl],
            brandId: [this.watch.brand.id],
            categoryId: [this.watch.category.id]
          })
        })

      })
    })

  }

  submit() {
    console.log(this.editWatch.value)
    this._watchService.updateWatch(this.editWatch.value).subscribe(data=>{
      console.log("success")
    })
  }
}

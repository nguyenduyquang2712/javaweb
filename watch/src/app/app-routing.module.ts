import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WatchComponent} from "./watch/watch.component";
import {CreateWatchComponent} from "./create-watch/create-watch.component";
import {EditWatchComponent} from "./edit-watch/edit-watch.component";
import {CartComponent} from "./cart/cart.component";


const routes: Routes = [
  {
    path:'',component:WatchComponent
  },
  {
    path:'create', component:CreateWatchComponent
  },
  {
    path:'edit/:id', component: EditWatchComponent
  },
  {
    path:'cart', component: CartComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

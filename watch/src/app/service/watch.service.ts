import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Watch} from "../model/watch";
import {WatchDto} from "../model/watch-dto";

@Injectable({
  providedIn: 'root'
})
export class WatchService {

  constructor(private _httpClient: HttpClient) {
  }

  getAllWatch(): Observable<any> {
    return this._httpClient.get<any>("http://localhost:8080/api/v1/watches");
  }

  getAllBrand(): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/brand')
  }

  getAllCategory(): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/category')
  }

  createWatch(watch: WatchDto): Observable<WatchDto> {
    return this._httpClient.post<any>('http://localhost:8080/api/v1/createWatch', watch)
  }

  getWatchById(watchId: number): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/watches/' + watchId)

  }

  updateWatch(watch: WatchDto): Observable<any> {
    return this._httpClient.put<any>('http://localhost:8080/api/v1/editWatch', watch)

  }

  deleteWatch(id: number): Observable<any> {
    return this._httpClient.delete<any>('http://localhost:8080/api/v1/deleteWatch/' + id)
  }

  addWatchToCard(id: number): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/addWatch/' + id)
  }

  getAllOrder(): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/getOrder');
  }

  updateCart(id: number, amount: number):Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/updateOrder/'+id+'/'+amount)
  }

  deleteOrder(id: number):Observable<any> {
    return this._httpClient.delete<any>('http://localhost:8080/api/v1/deleteOrderCart/'+id)
  }

  deleteAllOrder(): Observable<any> {
    return this._httpClient.delete<any>('http://localhost:8080/api/v1/deleteAllOrder')
  }

  searchWatch(value:string): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/searchWatch?searchName='+value)
  }

  searchBrand(id: number): Observable<any> {
    return this._httpClient.get<any>('http://localhost:8080/api/v1/searchBrand/'+id)
  }
}

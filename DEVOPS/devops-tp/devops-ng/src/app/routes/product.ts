import { FormComponent } from "../views/product/form/form.component";
import { ListComponent } from "../views/product/list/list.component";

export default [
  { path: 'product', component: ListComponent },
  { path: 'product/new', component: FormComponent },
];

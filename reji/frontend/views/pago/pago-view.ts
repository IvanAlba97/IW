import '@polymer/iron-icon/iron-icon';
import '@vaadin/vaadin-button';
import '@vaadin/vaadin-checkbox';
import '@vaadin/vaadin-combo-box';
import '@vaadin/vaadin-icons';
import '@vaadin/vaadin-select';
import '@vaadin/vaadin-template-renderer';
import '@vaadin/vaadin-text-field/vaadin-email-field';
import '@vaadin/vaadin-text-field/vaadin-text-area';
import '@vaadin/vaadin-text-field/vaadin-text-field';
import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators.js';

@customElement('pago-view')
export class PagoView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }
  
  render() {
    return html`
       <main class="grid gap-xl items-start justify-center max-w-screen-md mx-auto pb-l px-l">
       <vaadin-form-layout>
        <section class="flex flex-col flex-grow">
          <h2 class="mb-0 mt-xl text-3xl">PAGO</h2>
          <p class="mb-xl mt-0 text-secondary">Rellenar todos los campos</p>
          
          <section class="flex flex-col mb-xl mt-m">
            <p class="m-0 text-s text-secondary"></p>
            <h3 class="mb-m mt-s text-2xl">Datos Bancários</h3>
            <div class="flex flex-wrap gap-m">
              <vaadin-text-field
                class="flex-grow"
                label="Nombre de la tarjeta"
                pattern="[\\d ]{23,62}"
                required
              ></vaadin-text-field>
            </div>
            <div class="flex flex-wrap gap-m">
              <vaadin-select label="Tipo de tarjeta" required>
                <template>
                  <vaadin-list-box>
                    <vaadin-item>MasterCard</vaadin-item>
                    <vaadin-item>American Express</vaadin-item>
                    <vaadin-item>Visa</vaadin-item>
                  </vaadin-list-box>
                </template>
              </vaadin-select>
            <div class="flex flex-wrap gap-m">
              <vaadin-text-field
                class="flex-grow"
                label="Número de tarjeta"
                pattern="[\\d ]{12,23}"
                required
              ></vaadin-text-field>
              <vaadin-text-field label="Código de seguridad" pattern="[0-9]{3,4}" required>
              </vaadin-text-field>
            </div>
            <div class="flex flex-wrap gap-m">
              <vaadin-select label="Mes de expiración" required>
                <template>
                  <vaadin-list-box>
                    <vaadin-item>01</vaadin-item>
                    <vaadin-item>02</vaadin-item>
                    <vaadin-item>03</vaadin-item>
                    <vaadin-item>04</vaadin-item>
                    <vaadin-item>05</vaadin-item>
                    <vaadin-item>06</vaadin-item>
                    <vaadin-item>07</vaadin-item>
                    <vaadin-item>08</vaadin-item>
                    <vaadin-item>09</vaadin-item>
                    <vaadin-item>10</vaadin-item>
                    <vaadin-item>11</vaadin-item>
                    <vaadin-item>12</vaadin-item>
                  </vaadin-list-box>
                </template>
              </vaadin-select>
              <vaadin-select label="Año de expiración" required>
                <template>
                  <vaadin-list-box>
                    <vaadin-item>22</vaadin-item>
                    <vaadin-item>23</vaadin-item>
                    <vaadin-item>24</vaadin-item>
                    <vaadin-item>25</vaadin-item>
                    <vaadin-item>26</vaadin-item>
                  </vaadin-list-box>
                </template>
              </vaadin-select>
            </div>
          </section>
          <hr class="mb-xs mt-s mx-0" />
          <footer class="flex items-center justify-between my-m">
         
              <a href="cartelera" class="elements">
                <vaadin-button theme="tertiary-inline">Cancel</vaadin-button>
              </a>

              <a href="puente" class="elements">
                <vaadin-button theme="primary success">
                  <iron-icon icon="vaadin:lock" slot="prefix"></iron-icon>
                    Pay securely
                </vaadin-button>
              </a>
       
          </footer>
        </section>
        </vaadin-form-layout>
        <aside class="bg-contrast-5 box-border p-l rounded-l sticky">
          <header class="flex items-center justify-between mb-m">
            <h3 class="m-0">Pedido</h3>
            <vaadin-button theme="tertiary-inline">Edit</vaadin-button>
          </header>
          <ul class="list-none m-0 p-0 flex flex-col gap-m">
            <li class="flex justify-between">
              <div class="flex flex-col">
                <span>Entradas</span>
                <span class="text-s text-secondary"></span>
              </div>
              <span>$7.00</span>
            </li>
            <li class="flex justify-between">
              <div class="flex flex-col">
                <span>Comida</span>
                <span class="text-s text-secondary"></span>
              </div>
              <span>$8.00</span>
            </li>
            <li class="flex justify-between">
              <div class="flex flex-col">
                <span>Total</span>
                <span class="text-s text-secondary">Iva incluido
              </div>
              <span>$15.00</span>
            </li>
          </ul>
        </aside>
      </main>
    `;
  }
}

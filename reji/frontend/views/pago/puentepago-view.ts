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

@customElement('puentepago-view')
export class PagoView extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }

  render() {
    return html`
       <main class="grid gap-xl items-start pb-l px-l">
        <section class="flex flex-col flex-grow">
          <h2 class="mb-0 mt-xl text-3xl">PAGO</h2>
                  
          <hr class="mb-xs mt-s mx-0" />
          <footer class="flex items-center my-m">
         
              <a href="cartelera" class="elements">
                <vaadin-button theme="tertiary-inline">Cancel</vaadin-button>
              </a>
              
              <a href="pedido" class="elements">
                <vaadin-button theme="primary success">
                  <iron-icon icon="vaadin:lock" slot="prefix"></iron-icon>
                    Siguiente
                </vaadin-button>
              </a>
           
          </footer>
        </section>
      </main>
    `;
  }
}

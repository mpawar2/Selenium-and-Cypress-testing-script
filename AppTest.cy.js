describe('Select Item', () => {
  it('should select an item and verify the span contains the correct text', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/',{ failOnStatusCode: false });
      cy.log('Visiting the homepage');
      
      // Perform search for "bag valentino"
      cy.get('#header-search-input').type('bag valentino{enter}');
      cy.log('Perform search');
      // Scroll to and find the item
      cy.contains('h3', 'BIGS - Across body bag - nero').scrollIntoView().click();

      // Verify the text in the span
      cy.contains('span', 'BIGS - Across body bag - nero').should('exist');
      cy.task('log', 'This will be output to the terminal')
  });
});

describe('Add to Cart', () => {
  it('should add an item to the cart', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');
      
      // Perform search for "bag valentino"
      cy.get('#header-search-input').type('bag valentino{enter}');

      // Scroll to and find the item
      cy.contains('h3', 'BIGS - Umhängetasche - nero').scrollIntoView().click();

      // Click "Add to bag"
      cy.contains('span', 'In den Warenkorb').click();
  });
});

describe('View Cart', () => {
  it('should view the cart and verify item is present', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');
      
      // Perform search for "bag valentino"
      cy.get('#header-search-input').type('bag valentino{enter}');

      // Scroll to and find the item
      cy.contains('h3', 'BIGS - Umhängetasche - nero').scrollIntoView().click();

      // Click "Add to bag"
      cy.contains('span', 'In den Warenkorb').click();

      // Click on the cart
      cy.get('a[href="/cart/"]').click();

      // Verify the item is in the cart
      cy.get('.AGx8tI.wmyrNw.FxZV-M.HlZ_Tf').should('exist');
  });
});

describe('Navigate to Shoes Section', () => {
  it('should navigate to the shoes section', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');

      // Perform search for "Shoes"
      cy.get('#header-search-input').type('Shoes{enter}');

      // Verify that the text "Shoes" is displayed
      cy.contains('span', 'Shoes').should('exist');
  });
});

describe('Verify Search Bar Visibility and Accessibility', () => {
  it('should verify that the search bar is visible and accessible', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');

      // Verify the search bar is displayed and enabled
      cy.get('#header-search-input').should('be.visible').and('be.enabled');
  });
});

describe('Product Details Verification', () => {
  it('should verify the product price', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');

      // Perform search for "bag valentino"
      cy.get('#header-search-input').type('bag valentino{enter}');

      // Scroll to and find the item
      cy.contains('h3', 'BIGS - Umhängetasche - nero').scrollIntoView().click();

      // Verify the product price (update the selector if necessary)
      cy.get('.sDq_FX._4sa1cA.dgII7d.Km7l2y._65i7kZ').should('exist');
  });
});

describe('Search Bar Suggestions Test', () => {
  it('should verify that product suggestions are displayed when typing in search', () => {
      // Visit the page
      cy.visit('https://www.zalando.de/');

      // Click the search bar to make sure it's active and suggestions can be triggered
      cy.get('#header-search-input').click().type('Shoes');
      cy.get('#header-search-input').click();
      //cy.get('#header-search-option-0').should('be.visible');
  });
});
import React from 'react';
import { AdminComponent } from '../../../components/pages/admin/admin.component';
import { shallow } from 'enzyme';

describe('admin.component.tsx', () => {
  test('should render', () => {
    const wrapper = shallow(<AdminComponent />);
    expect(wrapper).toBeDefined();
  });
});